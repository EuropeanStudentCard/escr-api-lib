package fr.lescrous.escr.response;

/**
 * The type Generic error response.
 */
public class GenericErrorResponse {
    private String error;

    private String errorDescription;

    private String errorUri;

    /**
     * Gets error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Gets error description.
     *
     * @return the error description
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets error description.
     *
     * @param errorDescription the error description
     */
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    /**
     * Gets error uri.
     *
     * @return the error uri
     */
    public String getErrorUri() {
        return errorUri;
    }

    /**
     * Sets error uri.
     *
     * @param errorUri the error uri
     */
    public void setErrorUri(String errorUri) {
        this.errorUri = errorUri;
    }
}
