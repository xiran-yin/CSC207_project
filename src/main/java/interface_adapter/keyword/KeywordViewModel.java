package interface_adapter.keyword;

import interface_adapter.ViewModel;

public class KeywordViewModel extends ViewModel<KeywordState> {
    public KeywordViewModel() {
        super("Keyword");
        setState(new KeywordState());
    }
}
