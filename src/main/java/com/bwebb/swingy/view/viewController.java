package com.bwebb.swingy.view;

import com.bwebb.swingy.controller.GameController;
import com.bwebb.swingy.controller.views;
import com.bwebb.swingy.view.gui.Gui;
import com.bwebb.swingy.view.terminal.TerminalView;

public class viewController {
    private final GameController controller;

    public ViewInterface display = null;
    private final Gui guiView;
    private final TerminalView terminalView;
    protected DisplayStringHandler strHandler = new DisplayStringHandler();

    public viewController(GameController controller) {
        this.controller = controller;
        guiView = new Gui(controller, strHandler);
        terminalView = new TerminalView(strHandler);
    }

    public void setDisplay(views view) {
        switch (view) {
            case GUI -> switchToGui();
            default -> switchToTerminal();
        }
    }

    public void toggleDisplay() {
        if (display instanceof TerminalView)
            switchToGui();
        else
            switchToTerminal();
    }

    private void switchToGui() {
        display = guiView;
        guiView.setVisible(true);
        controller.getGame().state.printMe();
    }

    private void switchToTerminal() {
        guiView.setVisible(false);
        display = terminalView;
        controller.readConsole();
    }

    public Gui getGuiView() {
        return guiView;
    }
}
