package problem4.models;

public class Smartphone implements Call, Browse{

    @Override
    public void browseWWW(String webPage) {
        System.out.println(String.format("Browsing: %s!", webPage));
    }

    @Override
    public void callAnotherPhones(String number) {
        System.out.println(String.format("Calling... %s", number));
    }
}
