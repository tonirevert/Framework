package framework_v2.Modules.Client.Model.Utils.pager;
import framework_v2.Modules.Admin.Model.Utils.pager.*;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public class AutocompleteJComboBox extends JComboBox{
    private final Searchable<String,String> searchable;

    public AutocompleteJComboBox(Searchable<String,String> s){
	super();
	this.searchable = s;

	setEditable(true);
                
	Component c = getEditor().getEditorComponent();
	if ( c instanceof JTextComponent ){
            final JTextComponent tc = (JTextComponent)c;
            tc.getDocument().addDocumentListener(new DocumentListener(){
                            
		@Override
		public void changedUpdate(DocumentEvent arg0) {}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
                    update();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
                    update();
		}

		public void update(){
			//perform separately, as listener conflicts between the editing component
			//and JComboBox will result in an IllegalStateException due to editing 
			//the component when it is locked. 
			SwingUtilities.invokeLater(new Runnable(){

                            @Override
                            public void run() {
				List<String> founds = new ArrayList<String>(searchable.search(tc.getText()));
				Set<String> foundSet = new HashSet<String>();
				for ( String s : founds ){
                                    foundSet.add(s.toLowerCase());
				}

				Collections.sort(founds);//sort alphabetically
							
                                setEditable(false);
				removeAllItems();

				//if founds contains the search text, then only add once.
				if ( !foundSet.contains( tc.getText().toLowerCase()) ){
                                    addItem( tc.getText() );
				}

				for (String s : founds) {
                                    addItem(s);
				}

				setEditable(true);
				setPopupVisible(true);
                            }
			});
		}
            });

            //When the text component changes, focus is gained 
            //and the menu disappears. To account for this, whenever the focus
            //is gained by the JTextComponent and it has searchable values, we show the popup.
            tc.addFocusListener(new FocusListener(){
		@Override
		public void focusGained(FocusEvent arg0) {
                    if ( tc.getText().length() > 0 ){
                        setPopupVisible(true);
                    }
		}
                                
		@Override
		public void focusLost(FocusEvent arg0) {						
		}
            });
	}else{
            throw new IllegalStateException("Editing component is not a JTextComponent!");
	}
    }
}