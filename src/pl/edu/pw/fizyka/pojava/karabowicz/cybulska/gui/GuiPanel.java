package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.gui;
import pl.edu.pw.fizyka.pojava.karabowicz.cybulska.simulation.SimulationMainPanel;
import pl.edu.pw.fizyka.pojava.karabowicz.cybulska.universe.CelestialBodyPosition;
import pl.edu.pw.fizyka.pojava.karabowicz.cybulska.universe.Planet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;


public class GuiPanel extends JPanel implements ActionListener //Karabowicz
{
    JButton changeObjectColorButton, createObjectButton, drawOrbitsButton;
    JToggleButton onOfButton;
    JTextField massField, radiusField;
    JComboBox objectTypeChooser, backgroundColorChooser;
    JLabel objectLocationLabel, massLabel;
    JRadioButton objectLocationRadiusChooser;
    JRadioButton objectLocationRandomChooser;

    public ArrayList<Planet> planetArrayList;

    Color choosenObjectColor;
    String choosenObject;


    private static SimulationMainPanel simulationMainPanel;

    public GuiPanel()
    {
        planetArrayList = new ArrayList<>();

        this.setLayout(new BorderLayout());

        simulationMainPanel = new SimulationMainPanel();
        simulationMainPanel.setBackground(Color.DARK_GRAY);

        JPanel changeOptionsPanel = new JPanel();
        BoxLayout changeOptionsPanelLayout = new BoxLayout(changeOptionsPanel, BoxLayout.Y_AXIS);
        changeOptionsPanel.setLayout(changeOptionsPanelLayout);

        changeObjectColorButton = new JButton("Change Color");
        createObjectButton = new JButton("Create object");
        drawOrbitsButton = new JButton("Draw orbits");
        onOfButton = new JToggleButton("ON/OFF");

        objectLocationLabel = new JLabel("Location of the object");
        massLabel = new JLabel("Mass [in units of Earth mass]");

        massField = new JTextField("2.5");
        radiusField = new JTextField("15");

        String[] objectTypeList = {"Choose type of the object", "Planet", "Sun", "Moon"};
        objectTypeChooser = new JComboBox(objectTypeList);
        objectTypeChooser.setSelectedIndex(0);
        choosenObject="!";
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
                .addComponent(massLabel)
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
                .addComponent(massLabel)
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

        changeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        changeOptionsPanel.add(objectSettingsPanel);
        changeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        changeOptionsPanel.add(backgroundColorChooser);
        changeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        changeOptionsPanel.add(drawOrbitsButton);
        changeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        changeOptionsPanel.add(onOfButton);
        changeOptionsPanel.add(Box.createRigidArea(new Dimension(0, 250)));

        this.add(changeOptionsPanel, BorderLayout.LINE_END);
        this.add(simulationMainPanel, BorderLayout.CENTER);

        //listeners
        changeObjectColorButton.addActionListener
                ( e -> choosenObjectColor = JColorChooser.showDialog(null, "Choose Object Color", Color.yellow) );



        backgroundColorChooser.addActionListener(backgroundColorListener);
        objectTypeChooser.addActionListener(objectTypeChooserListener);
        createObjectButton.addActionListener(createObjectButtonListener);
        //drawOrbitsButton.addActionListener(drawOrbitsButtonListener);
        onOfButton.addItemListener(onOfItemListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    public void start() {simulationMainPanel.start();}
    public void stop() {simulationMainPanel.stop();}

    ItemListener onOfItemListener = new ItemListener()
    {
        public void itemStateChanged(ItemEvent itemEvent)
        {
            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED)
            {
                stop();
                System.out.println("Selected");
            }
            else
            {
                start();
                System.out.println("Deselected");
            }
        }
    };

    ActionListener backgroundColorListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int selected = ((JComboBox)e.getSource()).getSelectedIndex();
            if (selected == 0) {
                simulationMainPanel.setBackground(Color.DARK_GRAY);
            }
            else if (selected == 1) {
                simulationMainPanel.setBackground(Color.BLACK);
                System.out.println("----test1---");
            }
            else if (selected == 2) {
                simulationMainPanel.setBackground(Color.DARK_GRAY);
                System.out.println("---test2----");
            }
            else if (selected == 3) {
                simulationMainPanel.setBackground(Color.GRAY);
            }
            else if (selected == 4) {
                simulationMainPanel.setBackground(Color.WHITE);
            }
        }
    };
//Cybulska
    ActionListener objectTypeChooserListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int selected = ((JComboBox)e.getSource()).getSelectedIndex();
            if (selected == 0) { choosenObject="!"; }
            else if (selected == 1)
            {
                choosenObject = "Planet";
                System.out.println("----planeta---");
            }
            else if (selected == 2)
            {
                choosenObject ="Sun";
                System.out.println("---slonce----");
            }
            else if (selected == 3)
            {
                choosenObject ="Moon";
                System.out.println("---ksiezyc----");
            }

        }
    };

    ActionListener createObjectButtonListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            double mass, radius;
            CelestialBodyPosition center;

            try
            {
                mass = Double.parseDouble(massField.getText() ); //masa
                System.out.println("Masa: "+mass);

                if(objectLocationRadiusChooser.isSelected()) { radius = Double.parseDouble(radiusField.getText() ); } //promien
                else { radius = 30.5; } // Promien przy kliknieciu myszka
                System.out.println("Promien: "+radius);

                //Polozenie srodka
                if(objectLocationRandomChooser.isSelected()) { center = new CelestialBodyPosition(50,50); } //Wybor na podstawie klikniecia do zmiany !!!!!!!!!!!!!

                else { center = new CelestialBodyPosition(450, 300); }
                System.out.println("Srodek: "+center.getX()+" "+center.getY() );


                //Tworzenie obiektu
                if(choosenObject=="!")
                {
                    System.out.println("Nie wybrano obiektu!");
                    JOptionPane.showMessageDialog (null,"Choose object type.","Not choosen type of object.",JOptionPane.ERROR_MESSAGE );
                }
                if(choosenObject=="Planet")
                {
                    planetArrayList.add(new Planet(center,(int)radius,3000,choosenObjectColor,mass,20));
                    System.out.println("Pomyślnie dodano planete!!!");
                }
                if(choosenObject=="Sun")
                {
                    planetArrayList.add(new Planet(center,(int)radius,3000,choosenObjectColor,mass,80));
                    System.out.println("Pomyślnie dodano slonce!!!");
                }
                if(choosenObject=="Moon")
                {
                    planetArrayList.add(new Planet(center,(int)radius,3000,choosenObjectColor,mass,8));
                    System.out.println("Pomyślnie dodano ksiezyc!!!");
                }
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Wrong options!");
                JOptionPane.showMessageDialog (null,"Choose all correct settings.","Incorrect settings of new object.",JOptionPane.ERROR_MESSAGE );
            }

        }
    };


}
