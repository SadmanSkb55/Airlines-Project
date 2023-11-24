package application;

import javafx.event.ActionEvent;

public interface CommonScene {
	public void StatusAE(ActionEvent event) throws Exception;
	public void SReqAE(ActionEvent event) throws Exception;
	public void ComandRepAE(ActionEvent event) throws Exception;
	public void FlightstatAE(ActionEvent event) throws Exception;
	public void NoticeM(ActionEvent event) throws Exception;
}
