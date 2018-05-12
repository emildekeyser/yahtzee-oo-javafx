package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ui.GameSetupPanel;
import view.ui.GameSetupView;

public class Main extends Application
{
	public static void main(String[] args)
	{
		try
		{
			Application.launch(args);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		new GameSetupController(primaryStage);
	}
}
