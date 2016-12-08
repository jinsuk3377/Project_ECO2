package com.dankook.bsi.views;

import com.dankook.bsi.util.greenbuilding.GBXmlContext;
import com.dankook.bsi.util.greenbuilding.Opening;
import com.dankook.bsi.util.greenbuilding.Surface;
import com.dankook.bsi.util.IDF.IDF;
import com.dankook.bsi.util.IDF.IdfZoneList;
import com.dankook.bsi.util.geometry.EDIVector3;
import com.dankook.bsi.model.Ui_Model;
import com.dankook.bsi.util.Ui_Observer;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Geometry;
import javax.media.j3d.GraphicsConfigTemplate3D;
import javax.media.j3d.LineStripArray;
import javax.media.j3d.Material;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleFanArray;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

public class ModelViewPanel extends JPanel implements Ui_Observer, ActionListener {
	private static final long serialVersionUID = 1L;
	private JTree modelTreeView;
	private DefaultMutableTreeNode _rootNode;
	private SimpleUniverse simpleUniverse;
	private TransformGroup buildingTransform;
	private BranchGroup contentBranch;
	
	private Ui_Model _model = null;

	public ModelViewPanel(Ui_Model model) {
		_model = model;
		this._model.addObserver(this);
		setLayout(new BorderLayout(0, 0));
		createModelTree();
		createModelView();
		initOtherControls();
	}

	public void update(Object eventDispatcher) {
		updateControls();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (_model.loadedGbxmlFile()) {
			JOptionPane.showMessageDialog(this, "validation is not implemented yet!!", "validation success",
					1);
		}
	}

	private boolean canUseJava3D() {
		try {
			GraphicsConfigTemplate3D gconfigTemplate = new GraphicsConfigTemplate3D();
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getBestConfiguration(gconfigTemplate);
		} catch (Error e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void createModelView() {
		if (canUseJava3D()) {
			init3DScene();
		} else {
			showErrorMessageForFailedJava3DInitilization();
		}
	}

	private void init3DScene() {
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		Canvas3D canvas3D = new Canvas3D(config);
		add(canvas3D, "Center");

		this.simpleUniverse = new SimpleUniverse(canvas3D);

		ViewingPlatform viewingPlatform = this.simpleUniverse.getViewingPlatform();
		viewingPlatform.setNominalViewingTransform();
		this.simpleUniverse.getViewer().getView().setFrontClipPolicy(2);
		this.simpleUniverse.getViewer().getView().setBackClipPolicy(2);
		this.simpleUniverse.getViewer().getView().setBackClipDistance(10000000.0D);
		this.simpleUniverse.getViewer().getView().setVisibilityPolicy(2);

		this.simpleUniverse.getViewingPlatform().getViewPlatform().setActivationRadius(10000.0F);
	}

	private void showErrorMessageForFailedJava3DInitilization() {
		JLabel errorMsg = new JLabel("Java 3D Can not be initialized!");
		add(errorMsg, "East");
	}

	private void initOtherControls() {
		JPanel panel = new JPanel();
		add(panel, "South");
		panel.setLayout(new BorderLayout(0, 0));
	}

	private void createModelTree() {
		this._rootNode = new DefaultMutableTreeNode("Zones");
		this.modelTreeView = new JTree(this._rootNode);
		this.modelTreeView.setPreferredSize(new Dimension(150, 64));
		this.modelTreeView.setBounds(new Rectangle(0, 0, 200, 0));
		add(this.modelTreeView, "West");
	}

	private BranchGroup createContentBranchGraph() {
		initScene();
		setupBuilding();
		setupLights();
		setupView();
		setupUserInteraction();
		this.contentBranch.compile();
		return this.contentBranch;
	}

	private void initScene() {
		this.contentBranch = new BranchGroup();
		this.contentBranch.setCapability(17);
		this.contentBranch.setCapability(12);
		this.contentBranch.setCapability(13);
	}

	private void setupUserInteraction() {
		MouseRotate mouseRotate = new MouseRotate(this.buildingTransform);
		mouseRotate.setSchedulingBounds(new BoundingSphere());
		this.contentBranch.addChild(mouseRotate);

		MouseZoom mouseZoom = new MouseZoom(this.buildingTransform);
		mouseZoom.setSchedulingBounds(new BoundingSphere());
		this.contentBranch.addChild(mouseZoom);

		MouseTranslate mouseTranslate = new MouseTranslate(this.buildingTransform);
		mouseTranslate.setSchedulingBounds(new BoundingSphere());
		this.contentBranch.addChild(mouseTranslate);
	}

	private void setupBuilding() {
		this.buildingTransform = new TransformGroup();
		this.buildingTransform.setCapability(18);
		this.contentBranch.addChild(this.buildingTransform);

		Geometry building = loadGbXmlModel();
		Shape3D shape3d = new Shape3D(building);
		shape3d.setAppearance(getDefaultApperanceForBuilding());
		this.buildingTransform.addChild(shape3d);

		this.buildingTransform.addChild(new Shape3D(loadGbXmlModelWithLine()));

		if (isThereWindowsOn(this._model.getGbXml())) {
			this.buildingTransform.addChild(new Shape3D(loadWindowsWithLine()));
		}

		Color3f bgColor = new Color3f(0.0F, 0.0F, 0.0F);
		Background bgNode = new Background(bgColor);
		this.contentBranch.addChild(bgNode);
	}

	private boolean isThereWindowsOn(GBXmlContext gbXml) {
		for (String key : gbXml.surfaces.keySet()) {
			Surface surface = (Surface) gbXml.surfaces.get(key);
			if (surface.getOpenings().size() > 0) {
				return true;
			}
		}
		return false;
	}

	private void setupView() {
		Transform3D stepbackTransform = new Transform3D();
		stepbackTransform.setTranslation(new Vector3d(0.0D, 0.0D, 300.0D));

		this.simpleUniverse.getViewingPlatform().getViewPlatformTransform().setTransform(stepbackTransform);
	}

	private void setupLights() {
		BoundingSphere bounds = new BoundingSphere( new Point3d(-70.0D, 0.0D, 0.0D), 100000.0D);
		setupAmbientLight(bounds);
		setupDirectionalLight(bounds);
	}

	private void setupDirectionalLight(BoundingSphere bounds) {
		Color3f light1Color = new Color3f(0.8F, 0.8F, 0.8F);
		Vector3f light1Direction = new Vector3f(100.0F, 1.0F, 0.0F);

		DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		light1.setInfluencingBounds(bounds);
		this.contentBranch.addChild(light1);
	}

	private void setupAmbientLight(BoundingSphere bounds) {
		Color3f ambientColor = new Color3f(0.8F, 0.8F, 0.8F);
		AmbientLight ambientLightNode = new AmbientLight(true, ambientColor);
		ambientLightNode.setInfluencingBounds(bounds);
		ambientLightNode.setCapability(13);
		this.contentBranch.addChild(ambientLightNode);
	}

	private Appearance getDefaultApperanceForBuilding() {
		Appearance appear = new Appearance();
		Material material = new Material(/* 270 */ new Color3f(1.0F, 1.0F, 1.0F), new Color3f(0.01F, 0.01F, 0.01F),
				/* 272 */ new Color3f(0.7F, 0.7F, 0.7F), new Color3f(0.0F, 0.0F, 0.0F), /* 274 */ 0.0F);
		appear.setMaterial(material);
		return appear;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Geometry loadGbXmlModel() {
		GBXmlContext gbxml = this._model.getGbXml();
		
		Vector vertexCountes = new Vector();
		Vector points = new Vector();
		Vector normals = new Vector();

		for (String key : gbxml.surfaces.keySet()) {
			Surface surface = (Surface) gbxml.surfaces.get(key);

			Vector3f normal = calcNormalVector(surface);
			for (EDIVector3 point : surface.cartesianPoints) {
				points.add(new Point3d(point.x.doubleValue(), point.z.doubleValue(), -point.y.doubleValue()));
				normals.add(normal);
			}
			vertexCountes.add(Integer.valueOf(surface.cartesianPoints.size()));
		}

		int[] numberOfStrips = new int[vertexCountes.size()];
		for (int stripIndex = 0; stripIndex < vertexCountes.size(); stripIndex++) {
			numberOfStrips[stripIndex] = ((Integer) vertexCountes.get(stripIndex)).intValue();
		}

		TriangleFanArray rectangle = new TriangleFanArray(/* 307 */ points.size(), /* 308 */ 7, numberOfStrips);

		for (int i = 0; i < points.size(); i++) {
			rectangle.setColor(i, new Color3f(1.0F, 0.7F, 0.5F));
			rectangle.setCoordinate(i, (Point3d) points.get(i));
			rectangle.setNormal(i, (Vector3f) normals.get(i));
		}
		return rectangle;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Geometry loadGbXmlModelWithLine() {
		GBXmlContext gbxml = this._model.getGbXml();

		Vector vertexCountes = new Vector();
		Vector points = new Vector();
		Vector normals = new Vector();

		for (String key : gbxml.surfaces.keySet()) {
			Surface surface = (Surface) gbxml.surfaces.get(key);

			Vector3f normal = calcNormalVector(surface);
			for (EDIVector3 point : surface.cartesianPoints) {
				points.add(new Point3d(point.x.doubleValue(), point.z.doubleValue(), -point.y.doubleValue()));
				normals.add(normal);
			}
			vertexCountes.add(Integer.valueOf(surface.cartesianPoints.size()));
		}

		int[] numberOfStrips = new int[vertexCountes.size()];
		for (int stripIndex = 0; stripIndex < vertexCountes.size(); stripIndex++) {
			numberOfStrips[stripIndex] = ((Integer) vertexCountes.get(stripIndex)).intValue();
		}

		LineStripArray rectangle = new LineStripArray(/* 350 */ points.size(), /* 351 */ 5, numberOfStrips);

		for (int i = 0; i < points.size(); i++) {
			rectangle.setColor(i, new Color3f(0.0F, 0.0F, 0.05F));
			rectangle.setCoordinate(i, (Point3d) points.get(i));
		}

		return rectangle;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Geometry loadWindowsWithLine() {
		GBXmlContext gbxml = this._model.getGbXml();

		Vector vertexCountes = new Vector();
		Vector points = new Vector();

		for (String key : gbxml.surfaces.keySet()) {
			Surface surface = (Surface) gbxml.surfaces.get(key);

			for (Opening opening : surface.getOpenings()) {
				for (EDIVector3 point : opening.points) {
					points.add(new Point3d(point.x.doubleValue(), point.z.doubleValue(), -point.y.doubleValue()));
				}
				EDIVector3 initialPoint = (EDIVector3) opening.points.get(0);
				points.add(new Point3d(initialPoint.x.doubleValue(), initialPoint.z.doubleValue(),
						-initialPoint.y.doubleValue()));
				vertexCountes.add(Integer.valueOf(opening.points.size() + 1));
			}
		}

		int[] numberOfStrips = new int[vertexCountes.size()];
		for (int stripIndex = 0; stripIndex < vertexCountes.size(); stripIndex++) {
			numberOfStrips[stripIndex] = ((Integer) vertexCountes.get(stripIndex)).intValue();
		}

		LineStripArray rectangle = new LineStripArray(/* 394 */ points.size(), /* 395 */ 5, numberOfStrips);

		for (int i = 0; i < points.size(); i++) {
			rectangle.setColor(i, new Color3f(1.0F, 0.0F, 0.0F));
			rectangle.setCoordinate(i, (Point3d) points.get(i));
		}

		return rectangle;
	}

	private Vector3f calcNormalVector(Surface surface) {
		Vector3f vector1 = new Vector3f(((EDIVector3) surface.cartesianPoints.get(0)).x.floatValue(),
				((EDIVector3) surface.cartesianPoints.get(0)).z.floatValue(),
				-((EDIVector3) surface.cartesianPoints.get(0)).y.floatValue());

		Vector3f vector2 = new Vector3f(((EDIVector3) surface.cartesianPoints.get(1)).x.floatValue(),
				((EDIVector3) surface.cartesianPoints.get(1)).z.floatValue(),
				-((EDIVector3) surface.cartesianPoints.get(1)).y.floatValue());

		Vector3f vector3 = new Vector3f(((EDIVector3) surface.cartesianPoints.get(2)).x.floatValue(),
				((EDIVector3) surface.cartesianPoints.get(2)).z.floatValue(),
				-((EDIVector3) surface.cartesianPoints.get(2)).y.floatValue());

		Vector3f vec1 = new Vector3f();
		vec1.sub(vector2, vector1);

		Vector3f vec2 = new Vector3f();
		vec2.sub(vector3, vector1);

		Vector3f normal = new Vector3f();
		normal.cross(vec1, vec2);

		return normal;
	}

	private void updateControls() {
		if (this._model.loadedGbxmlFile()) {
			reconstructModelTree();
		}

		if (this._model.loadedGbxmlFile()) {

		} else {

		}

		if (this._model.loadedGbxmlFile()) {
			if (this.contentBranch != null) {
				this.simpleUniverse.getLocale().removeBranchGraph(this.contentBranch);
				this.contentBranch = null;
			}
			this.simpleUniverse.addBranchGraph(createContentBranchGraph());
		}
	}

	private void reconstructModelTree() {
		IDF idf = _model.getIdf();
		modelTreeView.clearSelection();
		modelTreeView.collapseRow(0);
		modelTreeView.removeAll();

		_rootNode.removeAllChildren();

		String[] zoneIds = new String[idf.zoneLists.size()];
		int idx = 0;
		for (String key : idf.zoneLists.keySet()) {
			IdfZoneList zoneList = idf.zoneLists.get(key);
			zoneIds[idx++] = zoneList.id();
		}
		Arrays.sort(zoneIds);

		for (String zoneId : zoneIds) {
			_rootNode.add(new DefaultMutableTreeNode(zoneId));
		}
	}
}