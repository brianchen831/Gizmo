import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import static java.lang.System.*;	
import javax.swing.*;
public class RoundCorners {

    public static BufferedImage makeRoundedCorner(BufferedImage image,
            int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius,
                cornerRadius));

        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        return output;
    }

}