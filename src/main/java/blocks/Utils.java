package blocks;

import org.openqa.selenium.WebElement;

public class Utils {

    public double parseToDoubleWithSplit(WebElement element) {
        String string = element.getAttribute("innerText");
        String[] s = string.split(" ");
        String newString = s[0].replace("€", "");
        return Double.parseDouble(newString);
    }

    public double parseToDouble(WebElement element) {
        String string = element.getAttribute("innerText").replace("€", "");
        return Double.parseDouble(string);
    }

    public int parseToInteger(WebElement element) {
        return Integer.parseInt(element.getAttribute("innerText"));
    }
}
