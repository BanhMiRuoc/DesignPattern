import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TriangleDrawingApp extends JFrame {
    private JPanel drawPanel;
    private Point A, B;
    private TriangleDrawer currentDrawer;
    private List<TriangleDrawer> triangles = new ArrayList<>();
    
    public TriangleDrawingApp() {
        setTitle("Triangle Drawing");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        String[] triangleTypes = {"Right Top", "Right Bottom", "Equilateral", "Isosceles", "Scalene"};
        for (String type : triangleTypes) {
            JButton button = new JButton(type);
            button.addActionListener(e -> setTriangleType(type));
            buttonPanel.add(button);
        }
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearScreen());
        buttonPanel.add(clearButton);
        
        add(buttonPanel, BorderLayout.NORTH);

        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (A != null && B != null) {
                    g.setColor(Color.BLACK);
                    g.drawLine(A.x, A.y, B.x, B.y);
                }
                for (TriangleDrawer triangle : triangles) {
                    triangle.draw(g);
                }
            }
        };
        drawPanel.setBackground(Color.WHITE);
        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                A = new Point(e.getX(), e.getY());
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                B = new Point(e.getX(), e.getY());
                repaint();
            }
        });
        add(drawPanel, BorderLayout.CENTER);
    }

    private void setTriangleType(String type) {
        switch (type) {
            case "Right Top":
                currentDrawer = new RightTriangleTop();
                break;
            case "Right Bottom":
                currentDrawer = new RightTriangleBottom();
                break;
            case "Equilateral":
                currentDrawer = new EquilateralTriangle();
                break;
            case "Isosceles":
                currentDrawer = new IsoscelesTriangle();
                break;
            case "Scalene":
                currentDrawer = new ScaleneTriangle();
                break;
        }
        if (A != null && B != null && currentDrawer != null) {
            currentDrawer.setPoints(A, B);
            triangles.add(currentDrawer);
            repaint();
        }
    }
    
    private void clearScreen() {
        triangles.clear();
        A = null;
        B = null;
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TriangleDrawingApp().setVisible(true));
    }
}
