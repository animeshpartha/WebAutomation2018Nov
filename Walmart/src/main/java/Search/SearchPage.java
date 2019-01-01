package Search;

import base.CommonAPI;

public class SearchPage extends CommonAPI {

    public void searchMenu(){
        typeOnElementEntry("#global-search-input", "mobile");
        navigateBack();
        typeOnElementEntry("#global-search-input", "TV");
        navigateBack();
        typeOnElementEntry("#global-search-input", "cloths");
        navigateBack();
        typeOnElementEntry("#global-search-input", "Samsung");
        navigateBack();
        typeOnElementEntry("#global-search-input", "Toys");
        navigateBack();
        typeOnElementEntry("#global-search-input", "Grocery");
        navigateBack();
    }
}
