package Modules.Config.Model.Classes;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class theme_class {

//Lines to view the available themes on the system
//	LookAndFeelInfo[] lista = UIManager.getInstalledLookAndFeels();
//	for (int i = 0; i < lista.length; i++) {
//		System.out.println(lista[i].getClassName());
//	}
	
//	javax.swing.plaf.metal.MetalLookAndFeel
//	javax.swing.plaf.nimbus.NimbusLookAndFeel
//	com.sun.java.swing.plaf.motif.MotifLookAndFeel
//	com.sun.java.swing.plaf.gtk.GTKLookAndFeel
	
	
                /**
                 * Used to set the desired Look And Feel for the application
                 * @param select Is the desired theme so select: (Metal, Windows, Motif, Nimbus)
                 */
	public static void selectedtheme(String select){
		
		try {
			switch (select) {
			case "Metal"://Metal theme
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				break;
			case "Windows"://Windows theme
//				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
				break;
			case "Motif"://CDE / Motif theme
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;
			case "Nimbus"://Nimbus
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error loading theme", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}//End of selected theme
}
