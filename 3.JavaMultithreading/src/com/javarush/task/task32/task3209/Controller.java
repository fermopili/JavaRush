package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Administrator on 24.04.2017.
 */
public class Controller
{
    private View         view;
    private HTMLDocument document;
    private File         currentFile;

    public HTMLDocument getDocument()
        {
        return document;
        }

    public void setDocument(HTMLDocument document)
        {
        this.document = document;
        }


    public Controller(View view)
        {
        this.view = view;
        }

    public static void main(String[] args)
        {
        View view = new View ( );
        view.init ( );
        Controller controller = new Controller (view);
        controller.init ( );
        view.setController (controller);
        }

    public void init()
        {
        createNewDocument ( );
        }

    public void initMenuBar()
        {
        }

    public void exit()
        {
        System.exit (0);
        }

    public void resetDocument()
        {
        UndoListener listener = view.getUndoListener ( );
        if (document != null)
            {
                document.removeUndoableEditListener (listener);
            }
        document = (HTMLDocument) new HTMLEditorKit ( ).createDefaultDocument ( );
        document.addUndoableEditListener (listener);
        view.update ( );
        }

    public void setPlainText(String text)
        {
        resetDocument ( );
        StringReader stringReader = new StringReader (text);
        try
            {
                new HTMLEditorKit ( ).read (stringReader, document, 0);
            }
        catch (Exception e)
            {
                ExceptionHandler.log (e);
            }
        }

    public String getPlainText()
        {
        StringWriter stringWriter = new StringWriter ( );
        try
            {
                new HTMLEditorKit ( ).write (stringWriter, document, 0, document.getLength ( ));
            }
        catch (Exception e)
            {
                ExceptionHandler.log (e);
            }
        return stringWriter.toString ( );
        }

    public void createNewDocument()
        {
        view.selectHtmlTab ( );
        resetDocument ( );
        view.setTitle ("HTML редактор");
        view.resetUndo ( );
        currentFile = null;
        }

    public void openDocument()
        {
        view.selectHtmlTab ( );
        JFileChooser fileChooser = new JFileChooser ( );
        fileChooser.setFileFilter (new HTMLFileFilter ( ));
        int retrival = fileChooser.showOpenDialog (view);
        if (retrival == JFileChooser.APPROVE_OPTION)
            {
                currentFile = fileChooser.getSelectedFile ( );
                resetDocument ( );
                view.setTitle (currentFile.getName ( ));
                try (FileReader fr = new FileReader (currentFile))
                    {
                        new HTMLEditorKit ( ).read (fr, document, 0);
                    }
                catch (Exception e)
                    {
                        ExceptionHandler.log (e);
                    }
                view.resetUndo ( );
            }
        }
    public void saveDocument()
        {
        view.selectHtmlTab ( );
        if (currentFile != null)
            try (FileWriter fw = new FileWriter (currentFile))
                {
                    new HTMLEditorKit ( ).write (fw, document, 0, document.getLength ( ));
                }
            catch (Exception e)
                {
                    ExceptionHandler.log (e);
                }
        else
            saveDocumentAs ( );

        }

    public void saveDocumentAs()
        {
        view.selectHtmlTab ( );
        JFileChooser fileChooser = new JFileChooser ( );
        fileChooser.setFileFilter (new HTMLFileFilter ( ));
        int retrival = fileChooser.showSaveDialog (view);
        if (retrival == JFileChooser.APPROVE_OPTION)
            {
                currentFile = fileChooser.getSelectedFile ( );
                view.setTitle (currentFile.getName ( ));
                try (FileWriter fw = new FileWriter (currentFile))
                    {
                        new HTMLEditorKit ( ).write (fw, document, 0, document.getLength ( ));
                    }
                catch (Exception e)
                    {
                        ExceptionHandler.log (e);
                    }
            }
        }
}
