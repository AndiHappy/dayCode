package designPattern.struct.decorator.example2;
// The Window interface class
public interface Window {
    public void draw(); // Draws the Window
    public String getDescription(); // Returns a description of the Window
}

// Extension of a simple Window without any scrollbars
class SimpleWindow implements Window {
    public void draw() {
        // Draw window
    }

    public String getDescription() {
        return "simple window";
    }
}