package command.media_player;

/**
 * Created by Beka on 10.04.17.
 */
public class RemoteControl {

    private ICommand command;
    private ICommand nextCommand;
    private ICommand previousCommand;

    public void setPlayPauseButtonCommand(ICommand command){
        this.command = command;
    }

    public void setNextCommand(ICommand command){
        this.nextCommand = command;
    }



    public void setPreviousCommand(ICommand command){
        this.previousCommand = command;
    }


    void onPausePlayButtonClickedEventListener(){
        if (command!=null){
            command.doAction();
        }
    }

}
