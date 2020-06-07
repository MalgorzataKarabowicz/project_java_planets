package pojavaKarabowiczCybulska.gui;



import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class PlanetarySystemSimulationMainFrame extends JFrame
{
    public static ScheduledExecutorService ogarniaczWatkow; // ########## WATKI ############

    PlanetarySystemSimulationMainFrame()
    {
        ogarniaczWatkow = Executors.newScheduledThreadPool(8);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setTitle("Planetary System Simulation");
        this.setJMenuBar(new DropDownMenu());   //Rozwijane menu

        GuiPanel guiPanel = new GuiPanel();

        this.add(guiPanel);

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JOptionPane.showMessageDialog (null,"In these program you can:\n" +
                        "* add only ONE sun, but you can change it mass\n" +
                        "* add a lot of planets\n" +
                        "* add new moon only to the LAST ADDED PLANET\n\n" +
                        "       Have a good time!","Instruction",JOptionPane.INFORMATION_MESSAGE );

                PlanetarySystemSimulationMainFrame mainFrame = new PlanetarySystemSimulationMainFrame();
                mainFrame.setVisible(true);
            }
        });

    }
}
