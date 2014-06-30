package org.vaadin.addon.vol3.client.layer;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractSingleComponentContainerConnector;
import org.vaadin.addon.vol3.client.source.OLSourceConnector;
import org.vaadin.gwtol3.client.layer.Layer;
import org.vaadin.gwtol3.client.source.Source;

import java.util.List;

/**
 * Created by mjhosio on 27/06/14.
 */
public abstract class OLLayerConnector extends AbstractSingleComponentContainerConnector {

    // we create a dummy widget since this connector is used
    // only to handle layer state serialization
    private static final Widget dummyWidget=new Label();

    public OLLayerConnector(){
        super();
    }

    @Override
    public Widget getWidget() {
        return dummyWidget;
    }

    protected OLSourceConnector getSourceConnector(){
        List<ComponentConnector> childComponents = this.getChildComponents();
        if(!childComponents.isEmpty()){
            return ((OLSourceConnector)childComponents.get(0));
        }
        return null;
    }

    @Override
    public void updateCaption(ComponentConnector connector) {
        // no-op
    }

    @Override
    public OLLayerState getState() {
        return (OLLayerState) super.getState();
    }

    /** Returns the underlying wrapped javascript source implementation
     *
     * @return the source implementation
     */
    public Source getSource(){
        return getSourceConnector().getSource();
    }

    /** Returns the underlying wrapped javascript layer implementation
     *
     * @return layer implementation
     */
    public abstract Layer getLayer();

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {
        // no-op
    }

    @OnStateChange("brightness")
    void updateBrightness(){
        if(getState().brightness!=null){
            getLayer().setBrightness(getState().brightness.doubleValue());
        }
    }

    @OnStateChange("contrast")
    void updateContrast(){
        if(getState().contrast!=null){
            getLayer().setContrast(getState().contrast.doubleValue());
        }
    }

    @OnStateChange("hue")
    void updateHue(){
        if(getState().hue!=null){
            getLayer().setHue(getState().hue.doubleValue());
        }
    }

    @OnStateChange("maxResolution")
    void updateMaxResolution(){
        if(getState().maxResolution!=null){
            getLayer().setMaxResolution(getState().maxResolution.doubleValue());
        }
    }

    @OnStateChange("minResolution")
    void updateMinResolution(){
        if(getState().minResolution!=null){
            getLayer().setMinResolution(getState().minResolution.doubleValue());
        }
    }

    @OnStateChange("opacity")
    void updateOpacity(){
        if(getState().opacity!=null){
            getLayer().setOpacity(getState().opacity.doubleValue());
        }
    }

    @OnStateChange("saturation")
    void updateSaturation(){
        if(getState().saturation!=null){
            getLayer().setSaturation(getState().saturation.doubleValue());
        }
    }

    @OnStateChange("visible")
    void updateVisible(){
        if(getState().visible!=null){
            getLayer().setVisible(getState().visible.booleanValue());
        }
    }
}
