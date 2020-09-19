package com.bwebb.swingy.view.viewController;

import com.bwebb.swingy.view.terminal.TerminalView;

public abstract class ViewController {
    private static int terminalSelector;
    private static int guiSelector = 1;

    public static void mainMenu(int view) {
        if (view == terminalSelector)
            TerminalView.terminalMainMenu();
    }

    public static void hype(int view) {
        if (view == terminalSelector)
            TerminalView.hype();
    }
}
