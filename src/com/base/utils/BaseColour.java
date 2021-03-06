package com.base.utils;

import javafx.scene.paint.Color;

/**
 * @since 0.1.69
 * @version 0.1.69
 * @author Innoxia
 */
public enum BaseColour {

	WHITE(Util.newColour(0xFFFFFF), Util.newColour(0x636363)),
	
	ROSE(Util.newColour(0xEBC2FF), Util.newColour(0xB800E6)),
	LILAC(Util.newColour(0x978AFF), Util.newColour(0x8170FF)),
	LILAC_LIGHT(Util.newColour(0xC2BDFF), Util.newColour(0x8E3DFF)),
	PURPLE_DARK(Util.newColour(0x740AFF), Util.newColour(0x6000D6)),
	PURPLE(Util.newColour(0xB980FF), Util.newColour(0x943DFF)),
	PURPLE_LIGHT(Util.newColour(0xDA8FFF), Util.newColour(0xC552FF)),
	
	VIOLET(Util.newColour(0xFF99C9), Util.newColour(0xFF57A5)),
	PINK(Util.newColour(0xFF6BDA), Util.newColour(0xFF0FC3)),
	PINK_LIGHT(Util.newColour(0xF5A8FF), Util.newColour(0xCF26BE)),
	PINK_DEEP(Util.newColour(0xFF33CC), Util.newColour(0xFF33CC)),
		
	MAGENTA(Util.newColour(0xFF1472), Util.newColour(0xFF1472)),
	CRIMSON(Util.newColour(0xFF385D), Util.newColour(0xFF385D)),
	RED(Util.newColour(0xEA5D76), Util.newColour(0xDD1D40)),
	RED_LIGHT(Util.newColour(0xEE95A6), Util.newColour(0xE9536F)),
	
	TAN(Util.newColour(0xEDC491), Util.newColour(0xDC8D2E)),
	BROWN(Util.newColour(0xD0A38B), Util.newColour(0xB5714A)),
	BROWN_DARK(Util.newColour(0x8E6A52), Util.newColour(0x785945)),
	ORANGE(Util.newColour(0xFF9970), Util.newColour(0xFA4700)),
	GINGER(Util.newColour(0xFF9147), Util.newColour(0xF06000)),
	
	GOLD(Util.newColour(0xFFCC00), Util.newColour(0xCCA300)),
	YELLOW(Util.newColour(0xECEC5B), Util.newColour(0xC4C700)),
	YELLOW_LIGHT(Util.newColour(0xF8F8B9), Util.newColour(0xC1A42F)),
	
	GREEN_LIME(Util.newColour(0xB4D987), Util.newColour(0x83BE3C)),
	GREEN_LIGHT(Util.newColour(0x8fefbf), Util.newColour(0x1DB96B)),
	GREEN(Util.newColour(0x1DB96B), Util.newColour(0x0D683B)),
	
	AQUA(Util.newColour(0x61FFFF), Util.newColour(0x009999)), // Ne, Kazuma...
	TEAL(Util.newColour(0x6CBCB1), Util.newColour(0x439389)),
	BLUE_LIGHT(Util.newColour(0x99EBFF), Util.newColour(0x00A7D1)),
	BLUE(Util.newColour(0x05CDFF), Util.newColour(0x00627A)),
	BLUE_STEEL(Util.newColour(0xA7B7D2), Util.newColour(0x5671A4)),
	
	BLACK(Util.newColour(0xB3B3B3), Util.newColour(0x1F1F1F));
	
	private Color colour, lightColour;

	private BaseColour(Color colour, Color lightColour) {
		this.colour = colour;
		this.lightColour = lightColour;
	}

	public Color getColour() {
		return colour;
	}

	public Color getLightColour() {
		return lightColour;
	}
	
	public String toWebHexString() {
		return getColour().toString().substring(2, 8);
	}
	
	/**
	 * Shades goes from dark to light. So shades[0] is the darkest.
	 * length 5
	 */
	public String[] getShades() {
		String[] shadesString = new String[5];
		float luminosity = -0.3f;
		String r = colour.toString().substring(2, 4), g = colour.toString().substring(4, 6), b = colour.toString().substring(6, 8), rgb = "#";
		int colourValue = Integer.parseInt(r, 16);

		for (int i = 0; i < 5; i++) {
			colourValue = Integer.parseInt(r, 16);
			colourValue += (colourValue * (i * 0.15f + luminosity));
			rgb += String.format("%02X", Math.max(Math.min(colourValue, 255), 0), 16);

			colourValue = Integer.parseInt(g, 16);
			colourValue += (colourValue * (i * 0.15f + luminosity));
			rgb += String.format("%02X", Math.max(Math.min(colourValue, 255), 0), 16);

			colourValue = Integer.parseInt(b, 16);
			colourValue += (colourValue * (i * 0.15f + luminosity));
			rgb += String.format("%02X", Math.max(Math.min(colourValue, 255), 0), 16);

			shadesString[i] = rgb;
			rgb = "#";
		}

		return shadesString;
	}
}
