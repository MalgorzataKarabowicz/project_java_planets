package pl.edu.pw.fizyka.pojava.karabowicz.cybulska;

import javax.swing.*;
import java.awt.*;


public class ChangeOptionsPanel extends JPanel //Karabowicz
{
    JButton changeObjectColorButton, createObjectButton, onOfButton;
    JTextField massField, radiusField;
    JComboBox objectTypeChooser, backgroundColorChooser;
    JLabel objectLocationLabel;
    JRadioButton objectLocationRadiusChooser, objectLocationRandomChooser;

    public ChangeOptionsPanel()
    {
        this.setLayout(new GridLayout(15, 1));

        changeObjectColorButton = new JButton("Change Color");
        createObjectButton = new JButton("Create object");
        onOfButton = new JButton("ON/OFF");

        objectLocationLabel = new JLabel("Location of the object");

        massField = new JTextField("Mass");
        radiusField = new JTextField("Radius");

        String[] objectTypeList = {"Wybierz rodzaj obiektu", "Planet", "Sun", "Moon"};
        objectTypeChooser = new JComboBox(objectTypeList);
        String[] backgroundColorList = {"Wybierz kolor tła", "Black", "Navy", "Gray", "White"};
        backgroundColorChooser = new JComboBox(backgroundColorList);

        objectLocationRadiusChooser = new JRadioButton(); //miałam problem z dodaniem tutaj pola tekstowego
        objectLocationRadiusChooser.setSelected(true);
        objectLocationRandomChooser = new JRadioButton("Place clicking the mouse");

        //JPanel objectLocationPanel = new JPanel();
        ButtonGroup objectLocationChooserGroup = new ButtonGroup();
        objectLocationChooserGroup.add(objectLocationRadiusChooser);
        objectLocationChooserGroup.add(objectLocationRandomChooser);

       //do poprawienia jutro!
        /* JPanel objectSettingsPanel = new JPanel();
        GroupLayout objectSettingsLayout = new GroupLayout(objectSettingsPanel);
        objectSettingsPanel.setLayout(objectSettingsLayout);
        objectSettingsLayout.setAutoCreateGaps(true);
        objectSettingsLayout.setAutoCreateContainerGaps(true);
        objectSettingsLayout.setVerticalGroup(
                objectSettingsLayout.createSequentialGroup()
                .addComponent(changeObjectColorButton)
                .addComponent(massField)
                .addComponent(objectTypeChooser)
                .addGroup(objectSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                    .addComponent(objectLocationLabel)
        );*/
       //this.add(objectSettingsPanel);

        this.add(changeObjectColorButton);
        this.add(massField);
        this.add(objectTypeChooser);
        this.add(objectLocationLabel);
        this.add(objectLocationRadiusChooser);
        this.add(objectLocationRandomChooser);
        this.add(createObjectButton);
        this.add(backgroundColorChooser);
        this.add(onOfButton);
    }

}
