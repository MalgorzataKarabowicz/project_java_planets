package pl.edu.pw.fizyka.pojava.karabowicz.cybulska;

import javax.swing.*;
import java.awt.*;


public class ChangeOptionsPanel extends JPanel //Karabowicz
{
    JButton changeObjectColorButton, createObjectButton, drawOrbitsButton, onOfButton;
    JTextField massField, radiusField;
    JComboBox objectTypeChooser, backgroundColorChooser;
    JLabel objectLocationLabel;
    JRadioButton objectLocationRadiusChooser, objectLocationRandomChooser;

    public ChangeOptionsPanel()
    {
        BoxLayout changeOptionsPanelLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(changeOptionsPanelLayout);

        changeObjectColorButton = new JButton("Change Color");
        createObjectButton = new JButton("Create object");
        drawOrbitsButton = new JButton("Draw orbits");
        onOfButton = new JButton("ON/OFF");

        objectLocationLabel = new JLabel("Location of the object");

        massField = new JTextField("Mass [kg]");
        radiusField = new JTextField("Radius [km]");

        String[] objectTypeList = {"Choose type of the object", "Planet", "Sun", "Moon"};
        objectTypeChooser = new JComboBox(objectTypeList);
        String[] backgroundColorList = {"Choose background color", "Black", "Navy", "Gray", "White"};
        backgroundColorChooser = new JComboBox(backgroundColorList);

        objectLocationRadiusChooser = new JRadioButton(); //miałam problem z dodaniem tutaj pola tekstowego
        objectLocationRadiusChooser.setSelected(true);
        objectLocationRandomChooser = new JRadioButton("Place clicking the mouse");

        ButtonGroup objectLocationChooserGroup = new ButtonGroup();
        objectLocationChooserGroup.add(objectLocationRadiusChooser);
        objectLocationChooserGroup.add(objectLocationRandomChooser);

        //panel with object settings
        JPanel objectSettingsPanel = new JPanel();
        GroupLayout objectSettingsLayout = new GroupLayout(objectSettingsPanel);
        objectSettingsPanel.setLayout(objectSettingsLayout);
        objectSettingsPanel.setBorder(BorderFactory.createTitledBorder("Object settings"));

        objectSettingsLayout.setAutoCreateGaps(true);
        objectSettingsLayout.setAutoCreateContainerGaps(true);
        objectSettingsLayout.linkSize(SwingConstants.HORIZONTAL, changeObjectColorButton, massField, objectTypeChooser, createObjectButton);

        objectSettingsLayout.setHorizontalGroup(objectSettingsLayout.createParallelGroup()
                                .addComponent(changeObjectColorButton)
                                .addComponent(massField)
                                .addComponent(objectTypeChooser)
                                .addComponent(objectLocationLabel)
                                .addGroup(objectSettingsLayout.createSequentialGroup()
                                .addPreferredGap(objectLocationLabel, objectLocationRadiusChooser, LayoutStyle.ComponentPlacement.INDENT)
                                        .addGroup(objectSettingsLayout.createParallelGroup()
                                                .addComponent(objectLocationRadiusChooser)
                                                .addComponent(objectLocationRandomChooser)
                                        )
                                )
                                .addComponent(createObjectButton)
        );
        objectSettingsLayout.setVerticalGroup(objectSettingsLayout.createSequentialGroup()
                                .addComponent(changeObjectColorButton)
                                .addComponent(massField)
                                .addComponent(objectTypeChooser)
                                .addComponent(objectLocationLabel)
                                .addComponent(objectLocationRadiusChooser)
                                .addComponent(objectLocationRandomChooser)
                                .addComponent(createObjectButton)

        );

        backgroundColorChooser.setAlignmentX(Component.CENTER_ALIGNMENT);
        drawOrbitsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        onOfButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(objectSettingsPanel);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(backgroundColorChooser);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(drawOrbitsButton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(onOfButton);
        this.add(Box.createRigidArea(new Dimension(0, 250)));
    }

}
