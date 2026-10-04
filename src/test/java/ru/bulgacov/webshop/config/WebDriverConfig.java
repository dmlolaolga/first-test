package ru.bulgacov.webshop.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${run}.properties",

})
public interface WebDriverConfig extends Config {
    // URL самого тестируемого сайта (WebShop)
    @Key("shopUrl")
    @DefaultValue("https://demowebshop.tricentis.com")
    String shopUrl();

    // Режим запуска: local или remote
    @DefaultValue("local")
    String run();

    // Настройки браузера
    @Key("browserName")
    @DefaultValue("edge")
    String browser();

    @DefaultValue("154.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    @Key("selenoidUrl")
    @DefaultValue("selenoid.autotests.cloud/wd/hub")
    String selenoidUrl();

    @Key("selenoidUser")
    @DefaultValue("user1")
    String selenoidUser();

    @Key("selenoidPassword")
    @DefaultValue("1234")
    String selenoidPassword();

    @DefaultValue("true")
    boolean enableVideo();

    @DefaultValue("true")
    boolean enableVNC();

    @DefaultValue("Lola test")
    String name();

    @DefaultValue("15")
    int sessionTimeout();
}
