package co.za.load.catalogue.exceptions;

public class LoadCatalogueException extends RuntimeException {

    public LoadCatalogueException(final Long id) {
        super("Ooops! The load does not seem to exist anymore... we are sorry for this...{ID: " + id+"}");
    }

    public LoadCatalogueException(final String description) {
        super(description);
    }
}
