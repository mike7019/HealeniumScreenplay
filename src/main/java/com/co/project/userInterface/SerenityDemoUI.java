package com.co.project.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

  public class SerenityDemoUI {
    public static final Target TXT_USER = Target.the("txt")
            .located(By.id("LoginPanel0_Username"));
    public static final Target TXT_PASS = Target.the("txt")
            .located(By.xpath("//input[@id='LoginPanel0_Password']"));
    public static final Target BTN_SUBMIT = Target.the("txt")
            .located(By.xpath("//button[@id='LoginPanel0_LoginButton']"));
    public static final Target TXT_VALIDATION = Target.the("txt")
            .located(By.xpath("//h1"));

}