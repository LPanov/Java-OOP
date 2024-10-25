package InterfaceAndAbstractionExercises.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder str = new StringBuilder();
        urls.forEach(url -> {
            if (url.matches(".*\\d+.*")) {
                str.append("Invalid URL!\n");
            }
            else {
                str.append("Browsing: ")
                        .append(url).append("!").append("\n");
            }
        });
        return str.toString();
    }

    @Override
    public String call() {
        StringBuilder str = new StringBuilder();
        numbers.forEach(number -> {
            if (number.matches(".*[a-zA-Z]+.*")) {
                str.append("Invalid number!\n");
            }
            else {
                str.append("Calling... ")
                        .append(number).append("\n");
            }
        });
        return str.toString();
    }
}
