package web.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.cermati.com/app/gabung")
public class RegisterObjects extends PageObject {
        public static Target NO_HANDPHONE_FIELD = Target.the("no handphone")
                        .locatedBy("#mobilePhone");
        public static Target EMAIL_FIELD = Target.the("email field")
                        .locatedBy("#email");
        public static Target FIRSTNAME_FIELD = Target.the("firstname field")
                        .locatedBy("#firstName");
        public static Target LASTNAME_FIELD = Target.the("lastname field")
                        .locatedBy("#lastName");
        public static Target REGISTER_BUTTON = Target.the("register button")
                        .locatedBy("#register-button");

        // PIN
        public static final Target PIN_FIELD = Target.the("PIN field")
                        .locatedBy("#pin");
        public static final Target CONFIRM_PIN_FIELD = Target.the("confirm PIN field")
                        .locatedBy("#confirmPin");

        // verifikasi OTP
        public static final Target OTP_FIELD_1 = Target.the("OTP field 1")
                        .locatedBy("#otp-1");
        public static final Target OTP_FIELD_2 = Target.the("OTP field 2")
                        .locatedBy("#otp-2");
        public static final Target OTP_FIELD_3 = Target.the("OTP field 3")
                        .locatedBy("#otp-3");
        public static final Target OTP_FIELD_4 = Target.the("OTP field 4")
                        .locatedBy("#otp-4");
        public static final Target VERIFY_BUTTON = Target.the("verify button")
                        .locatedBy("#verify-button");

        // Status Registrasi
        public static final Target REGISTER_SUCCESSFUL = Target.the("register successful message")
                        .locatedBy("#register-successful");
        public static final Target REGISTER_FAILED = Target.the("register failed message")
                        .locatedBy("#register-failed");
        public static final Target VALIDATE_EMAIL = Target.the("validate email message")
                        .locatedBy("#validate-email");
}
