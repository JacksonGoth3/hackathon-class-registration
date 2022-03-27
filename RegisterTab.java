import javax.swing.JPanel;

public abstract class RegisterTab {

	protected abstract void initIOPanel();
	protected abstract void initTablePanel();
	public abstract JPanel getIOPanel();
	public abstract JPanel getTablePanel();
	
}
