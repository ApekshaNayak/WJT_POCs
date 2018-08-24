package com.wijjit.api.utility.manager.constants;

public class Constants {
	private Constants() {

	}

	public static final long CIVIC_TOKEN_EXPIRY_MILLI_SECONDS = 3 * 60000;

	public static final long EMAIL_TOKEN_EXPIRY_MILLI_SECONDS = 3 * 60000;

	public static final String allTell_Gateway = "message.alltel.com";

	public static final String att_Gateway = "mms.att.net";

	public static final String bootmobile_Gateway = "myboostmobile.com";

	public static final String cricektwireless_Gateway = "mms.cricketwireless.net";

	public static final String sprint_Gateway = "messaging.sprintpcs.com";

	public static final String tmobile_Gateway = "tmomail.net";

	public static final String uscellular_Gateway = "email.uscc.net";

	public static final String verizon_Gateway = "vtext.com";

	public static final String virginmobile_Gateway = "vmobl.com";

	public static final String replublicwireless_Gateway = "text.republicwireless.com";

	public static String[] TXT_GATEWAYS = { replublicwireless_Gateway, virginmobile_Gateway, allTell_Gateway,
			bootmobile_Gateway, cricektwireless_Gateway, sprint_Gateway, uscellular_Gateway, att_Gateway,
			tmobile_Gateway, verizon_Gateway };

}
