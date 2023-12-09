import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MailTemplateGenerator extends JFrame {

    private JTextField companyNameField;
    private JTextField locationField;
    private JTextField nameField;
    private JTextField roleField;
    private JTextArea mailTemplateArea;
    private JLabel dateLabel;

    public MailTemplateGenerator() {
        // Set up the JFrame
        setTitle("Mail Template Generator");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel companyNameLabel = new JLabel("Company Name:");
        JLabel locationLabel = new JLabel("Location:");
        JLabel nameLabel = new JLabel("Your Name:");
        JLabel roleLabel = new JLabel("Role:");
        JLabel messageLabel = new JLabel("Made by Sahil Shrestha ❤️");

        dateLabel = new JLabel("Date: " + getCurrentDate());

        companyNameField = new JTextField(10);
        locationField = new JTextField(10);
        nameField = new JTextField(10);
        roleField = new JTextField(10);

        JButton generateButton = new JButton("Generate Template");
        generateButton.setPreferredSize(new Dimension(150, 25)); // Set preferred size for the button

        mailTemplateArea = new JTextArea();
        mailTemplateArea.setEditable(false);
        mailTemplateArea.setLineWrap(true);  // Enable line wrapping
        mailTemplateArea.setWrapStyleWord(true);  // Enable word wrapping
        mailTemplateArea.setRows(30);
        mailTemplateArea.setColumns(30);

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setLayout(new GridLayout(5, 5, 10, 10));
        inputPanel.add(companyNameLabel);
        inputPanel.add(companyNameField);
        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(roleLabel);
        inputPanel.add(roleField);
        inputPanel.add(messageLabel);
        inputPanel.add(generateButton);


        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(mailTemplateArea), BorderLayout.CENTER);

        // Add action listener to the button
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateMailTemplate();
            }
        });
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        return dateFormat.format(new Date());
    }

    private void generateMailTemplate() {
        // Replace placeholders in the template with the entered values
        String template = """
                
                [DATE]
                                
                                
                Hiring Manager
                                
                [COMPANY_NAME]
                                
                [LOCATION]
                                
                                
                Dear Hiring Manager,
                                
                                
                I am enthused to apply for the [ROLE] position at [COMPANY_NAME].  As a soon-to-be graduate of the Tribhuvan University IOST with a degree in Computer Science and Information Technology, I believe my academic training in .NET makes me a strong candidate for this role.
                                
                                
                In my coursework, I have become well-versed in C#, ASP.NET Core, Entity Framework, and other key .NET technologies. Through hands-on projects and assignments, I have developed web applications using the latest .NET frameworks. Although I do not yet have professional experience in .NET development, I have a solid understanding of its programming concepts and tools.
                                
                                
                Beyond technical skills, I possess a studious nature and willingness to learn on the job. I am eager to further expand my .NET expertise by contributing to real-world projects as an intern at  [COMPANY_NAME].
                                
                The opportunity to learn from your talented development teams would aid my goal of building a career as a .NET developer. My academic training has prepared me well to hit the ground running as an intern, while soaking up practical lessons from your experienced staff.
                                
                                
                Please review my enclosed resume detailing my education credentials. I hope to have the chance to discuss how I can support your .NET efforts, gain invaluable experience, and become a productive member of the  [COMPANY_NAME] team as an intern. Thank you for your consideration.
                                
                                
                Sincerely,
                                
                                
                [YOUR_NAME]""";

        String companyName = companyNameField.getText();
        String location = locationField.getText();
        String name = nameField.getText();
        String role = roleField.getText();
        String currentDate = getCurrentDate();

        // Replace placeholders with actual values
        template = template.replace("[COMPANY_NAME]", companyName);
        template = template.replace("[LOCATION]", location);
        template = template.replace("[YOUR_NAME]", name);
        template = template.replace("[ROLE]", role);
        template = template.replace("[DATE]", currentDate);

        // Display the generated template
        mailTemplateArea.setText(template);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MailTemplateGenerator().setVisible(true);
            }
        });
    }
}
