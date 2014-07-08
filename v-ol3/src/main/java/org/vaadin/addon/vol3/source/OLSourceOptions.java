package org.vaadin.addon.vol3.source;

import org.vaadin.addon.vol3.client.OLExtent;

/**
 * Created by mjhosio on 07/07/14.
 */
public class OLSourceOptions {
    private String [] attributions;
    private OLExtent extent;
    private String logo;
    // crs name of the projection
    private String projection;

    public String[] getAttributions() {
        return attributions;
    }

    public void setAttributions(String[] attributions) {
        this.attributions = attributions;
    }

    public OLExtent getExtent() {
        return extent;
    }

    public void setExtent(OLExtent extent) {
        this.extent = extent;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getProjection() {
        return projection;
    }

    /** Sets the csr name of the used projection
     *
     * @param projection
     */
    public void setProjection(String projection) {
        this.projection = projection;
    }
}