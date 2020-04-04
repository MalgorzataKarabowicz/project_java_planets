package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChangeOptionsPanel extends JPanel implements ActionListener //Karabowicz
{
    JButton changeObjectColorButton, createObjectButton, drawOrbitsButton, onOfButton;
    JTextField massField, radiusField;
    JComboBox objectTypeChooser, backgroundColorChooser;
    JLabel objectLocationLabel;
    JRadioButton objectLocationRadiusChooser;
    JRadioButton objectLocationRandomChooser;
    Color objectColor;
    static Color backgroundColor;

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
        radiusField = new JTextField();

        String[] objectTypeList = {"Choose type of the object", "Planet", "Sun", "Moon"};
        objectTypeChooser = new JComboBox(objectTypeList);
        objectTypeChooser.setSelectedIndex(0);
        String[] backgroundColorList = {"Choose background color", "Black", "Dark Gray", "Light Gray", "White"};
        backgroundColorChooser = new JComboBox(backgroundColorList);
        backgroundColorChooser.setSelectedIndex(0);

        objectLocationRadiusChooser = new JRadioButton("Radius [km]");
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
                                .addGroup(objectSettingsLayout.createSequentialGroup()
                                        .addPreferredGap(objectLocationRadiusChooser, radiusField, LayoutStyle.ComponentPlacement.INDENT)
                                        .addComponent(radiusField)
                                )
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
                .addComponent(radiusField)
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

        //listeners
        changeObjectColorButton.addActionListener(e ->
                objectColor = JColorChooser.showDialog(null, "Choose Object Color", Color.yellow)
        );

        //objectTypeChooser.addActionListener(objectTypeChooserListener);
        //createObjectButton.addActionListener(createObjectButtonListener);
        backgroundColorChooser.addActionListener(backgroundColorListener);
        //drawOrbitsButton.addActionListener(drawOrbitsButtonListener);
        //onOfButton.addActionListener(onOfButtonListener);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    ActionListener backgroundColorListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selected = ((JComboBox)e.getSource()).getSelectedIndex();
            if (selected == 0) {
                backgroundColor = Color.DARK_GRAY;
                System.out.println("----test----");
            }
            else if (selected == 1) {
                backgroundColor = Color.BLACK;
                System.out.println("----test1---");
            }
            else if (selected == 2) {
                backgroundColor = Color.DARK_GRAY;
                System.out.println("---test2----");
            }
            else if (selected == 3)
                backgroundColor = Color.GRAY;
            else if (selected == 4)
                backgroundColor = Color.WHITE;

        }
    };

}
