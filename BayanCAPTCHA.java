package com.bayanrasooly;

import autoitx4java.AutoItX;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.*;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.*;
import java.net.URLConnection.*;
import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BayanCAPTCHA {
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();
    public static int gmailNumb = 0;
    public static int gmailNumb1 = 0;
    @SuppressWarnings("all")
    public static void main(String []args) throws IOException {//3.83.111.93:3128:p11f408g:r6zt65qW3f
        //splitEmails(getGmails()); //fill up attributes
        System.out.println("\n\n\n\n\n  ###############################\n" +
                "#################################\n" +
                "#################################\n" +
                "  ###############################\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "\t      BayanCAPTCHA\t    #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                            #####\n" +
                "                           #####\n" +
                "##       \t\t          #####\n" +
                "###                      #####\n" +
                "############################\n" +
                " #########################\n\n\n\n\n");
        ArrayList<String> hol = new ArrayList<String>();
        Scanner cons = new Scanner(System.in);
        while(true){
            System.out.println("Keep enter gmail - format example@gmail.com:password - enter -1 when finished");
            String str = cons.next();
            if(!str.equals("-1")) {
                hol.add(str);
                gmailNumb++;
            }
            else
                break;
        }
        splitEmails(hol);
        String projectLocation = System.getProperty("user.dir");
        System.out.println(projectLocation);

        System.setProperty("webdriver.gecko.driver", "./dep/geckodriver"); //PATH
        for(int k = 0; k < gmailNumb; k++){
            new Thread(new MyRunnable()).start();
        }
    }
    public static void startSearches() throws FileNotFoundException, MalformedURLException {
        Proxy proxy = new Proxy();//atm no proxies being used, you can adjust this.

        proxy.setHttpProxy("3.83.111.93:3128");
        proxy.setSslProxy("3.83.111.93:3128");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        String autoFilePath = "./dep/AutoAuth-3.1.1";
        FirefoxProfile profile = new FirefoxProfile();
        profile.addExtension(new File(autoFilePath));

        FirefoxBinary firefoxBinary = new FirefoxBinary();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setProfile(profile);
        //FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability("proxy", proxy);
        FirefoxOptions options = new FirefoxOptions();
        //FirefoxProfile profile = new FirefoxProfile();
        Point point = new Point(-2000,800);
        options.addArguments("--user-agent=YOUR_USER_AGENT-user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
        options.addArguments("--disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        File d = new File("./dep/AutoAuth-3.1.1");
        //options.addExtensions(new File("/path/to/extension.crx"));
       // driver.installExtension(new File("/path/to/extension.crx"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        int i = gmailNumb1;
        gmailNumb1++;
        WebDriver driver = new FirefoxDriver(capabilities);
        Dimension dimension = new Dimension(0, 0);
        //driver.manage().window().setPosition(point);
        //driver.manage().window().setSize(dimension);
        //driver.get("https://addons.mozilla.org/firefox/downloads/file/853468/autoauth-3.1.1-an+fx.xpi?src=dp-btn-primary");
        System.out.println("0) Successfully opened firefox\n");
        //driver.get("http://addons.mozilla.org/firefox/downloads/file/853468/autoauth-3.1.1-an+fx.xpi?src=dp-btn-primary");
        //driver.manage().window().setPosition(point);
        //capabilities.setCapability("proxy", proxy);
        driver.get("http://google.com");
        System.out.println("1) Successfully opened google.com\n");
        //try {TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        ///driver.findElement(By.id("username")).sendKeys("p11f408g");
        //try {TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //driver.findElement(By.id("pw")).sendKeys("r6zt65qW3f");
        //try {TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //driver.findElement(By.id("submit")).click();
        //try {TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //capabilities.setCapability("proxy", proxy);
        WebElement goToGmail = driver.findElement(By.xpath("//*[@id=\"gb_70\"]"));
        goToGmail.click();
        System.out.println("1) Successfully opened gmail\n");

        try {TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement EmailID = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
usernames.get(i);
        EmailID.sendKeys(usernames.get(i));
        System.out.println("2) Successfully logging in\n");
        try {TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement nextBoxUser = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
        nextBoxUser.click();
        System.out.println("3) Moving to password page\n");
        try {TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        WebElement passBox = null;
        while(passBox == null) {
            try {
                passBox = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
            }
            catch (Throwable t) {
            }
        }
        System.out.println("4) Found item\n");
        try {TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        passBox.sendKeys(passwords.get(i));

        System.out.println("5) Logged in!");
        WebElement nextBoxPass = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));
        nextBoxPass.click();
        System.out.println("6) One Click Process begun...\n");

        try {TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.get("https://google.com/");

        try {TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        while(true) {
            String search = String.format("https://www.google.com/search?source=hp&ei=IrI6W_e4EMnn5gLloKzgDQ&q=%s&oq={}&gs_l=psy-ab.12..0j0i131k1j0l4j0i131k1l2j0l2.1514.155452.0.177155.20.5.15.0.0.0.110.250.4j1.5.0....0...1c.1.64.psy-ab..0.20.340...0i10k1.0.wl_aQzdHSe4", (choose() + " " + choose()));
            driver.get(search);
            System.out.println("Sent a search\n Starting youtube vid on new thread\n");
            try {TimeUnit.SECONDS.sleep(9); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
    public static ArrayList<String> getGmails() throws IOException {
        File file = new File("./dep/accounts.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        ArrayList<String> gmailList = new ArrayList<String>();

        while ((st = br.readLine()) != null){
            gmailList.add(st);
        }
        return gmailList;
    }
    public static void splitEmails(ArrayList<String> arr){
        for(int i = 0; i < arr.size(); i++){
            String raw = arr.get(i);

            usernames.add(raw.substring(0, raw.indexOf(":")));
            passwords.add(raw.substring(raw.indexOf(":") + 1));

            System.out.println(usernames.get(i));//debugging
            System.out.println(passwords.get(i));//debugging
        }
    }
    public static String choose() throws FileNotFoundException
    {
        File f = new File("./dep/Meaningful Words.txt");
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(f); sc.hasNext(); )
        {
            ++n;
            String line = sc.nextLine();
            if(rand.nextInt(n) == 0)
                result = line;
        }

        return result;
    }

    public static void setProxy() {
        System.setProperty("http.proxyHost", "3.83.111.93");
        System.setProperty("http.proxyPort", "3128");
        System.setProperty("https.proxyHost", "3.83.111.93");
        System.setProperty("https.proxyPort", "3128");
        System.setProperty("java.net.useSystemProxies", "true");
        Authenticator.setDefault(new ProxyAuth("p11f408g", "r6zt65qW3f"));
    }
    public static class ProxyAuth extends Authenticator {
        private PasswordAuthentication auth;

        private ProxyAuth(String user, String password) {
            auth = new PasswordAuthentication(user, password == null ? new char[]{} : password.toCharArray());
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return auth;
        }
    }

    public static class MyRunnable implements Runnable {
        public void run(){
            try {
                startSearches();
            } catch (IOException e) {
            }
        }
    }
}
