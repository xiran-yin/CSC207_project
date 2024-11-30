package interface_adapter.keyword;

import interface_adapter.ViewModel;

/**
 * The View Model for Keyword View Model.
 */
public class KeywordViewModel extends ViewModel<KeywordState> {
    public KeywordViewModel() {
        super("Keyword");
        setState(new KeywordState());
    }
}
