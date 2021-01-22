package controller;

import model.*;
import model.Point;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final PaintCanvasBase paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, PaintCanvasBase MyPaintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.paintCanvas = MyPaintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
    }

    public void mouseReleased(Point pressedPoint, Point releasedPoint){
        if(applicationState.getActiveMouseMode() == MouseMode.DRAW){
            if(applicationState.getActiveShapeType() == ShapeType.RECTANGLE){
                drawRectangle(pressedPoint, releasedPoint);
            }

            if(applicationState.getActiveShapeType() == ShapeType.TRIANGLE){
               //drawRectangle(pressedPoint, releasedPoint);
            }

            if(applicationState.getActiveShapeType() == ShapeType.ELLIPSE){
                //drawRectangle(pressedPoint, releasedPoint);
            }
        }
    }

    public void drawRectangle(Point startingPoint, Point endingPoint){
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        setActiveColor(graphics2d);

        if(applicationState.getActiveShapeShadingType() == ShapeShadingType.FILLED_IN){
            int width = startingPoint.calcWidth(startingPoint, endingPoint);
            int height = startingPoint.calcHeight(startingPoint, endingPoint);
            graphics2d.fillRect(startingPoint.x, startingPoint.y, width, height);
        }
    }

    private void setActiveColor(Graphics2D myGraphics2d){
        switch (applicationState.getActivePrimaryColor()){
            case BLACK:
                myGraphics2d.setColor(Color.BLACK);
                break;
            case BLUE:
                myGraphics2d.setColor(Color.BLUE);
                break;
            case CYAN:
                myGraphics2d.setColor(Color.CYAN);
                break;
            case DARK_GRAY:
                myGraphics2d.setColor(Color.DARK_GRAY);
                break;
            case GRAY:
                myGraphics2d.setColor(Color.GRAY);
                break;
            case GREEN:
                myGraphics2d.setColor(Color.GREEN);
                break;
            case LIGHT_GRAY:
                myGraphics2d.setColor(Color.LIGHT_GRAY);
                break;
            case MAGENTA:
                myGraphics2d.setColor(Color.MAGENTA);
                break;
            case ORANGE:
                myGraphics2d.setColor(Color.ORANGE);
                break;
            case PINK:
                myGraphics2d.setColor(Color.PINK);
                break;
            case RED:
                myGraphics2d.setColor(Color.RED);
                break;
            case WHITE:
                myGraphics2d.setColor(Color.WHITE);
                break;
            case YELLOW:
                myGraphics2d.setColor(Color.YELLOW);
                break;
        }
    }
    /*
    public void drawTriangle(Point startingPoint, Point endingPoint){
        System.out.println("NOT DONE");
    }

    public void drawEllipse(Point startingPoint, Point endingPoint){
        System.out.println("NOT DONE");
    }
    */
}
        /*
        // Filled in rectangle
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(12, 13, 200, 400);

        // Outlined rectangle
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(7, 8, 210, 410);
         */