package interp;

import org.antlr.runtime.tree.*;
import org.antlr.runtime.Token;

/**
 * Class to extend the nodes of the AST. It includes two fields
 * to store the value of literals and strings.
 * This class is not strictly necessary, since the literals could
 * be extracted from the "text" fields of the tokens.
 * However, it helps to understand how to extend AST nodes in ANTLR.
 */
 
public class ATNTree extends CommonTree {
    /** Field to store integer literals */
    private int intValue;

    /** Field to store string literals (without the enclosing quotes) */
    private String strValue;

    /** Constructor of the class */
    public ATNTree(Token t) {
        super(t);
    }

    /** Function to get the child of the node. */
    public ATNTree getChild(int i) {
        return (ATNTree) super.getChild(i);
    }

    /** Get the integer value of the node. */
    public int getIntValue() { return intValue;}

    /** Define the integer value of the node. */
    public void setIntValue() { intValue = Integer.parseInt(getText()); }

    /** Get the Boolean value of the node. */
    public boolean getBooleanValue() { return intValue != 0; }

    /** Define the Boolean value of the node. */
    public void setBooleanValue() {
        intValue = getText().equals("true") ? 1 : 0;
    }

    /** Get the string value of the node. */
    public String getStringValue() { return strValue; }

    /**
     * Define the string value of the node. It removes the
     * enclosing quotes. In this way, it can be printed as it is.
     */
    public void setStringValue() {
        String s = getText();
        // Do not store the " at the extremes of the string
        strValue = s.substring(1,s.length()-1);
    }
}
