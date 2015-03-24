package org.vaadin.artur.springchat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SpringMessenger {

	List<SpringChatUI> uis = new ArrayList<>();

	public synchronized void addMessageListener(SpringChatUI ui) {
		System.out.println("Add listener: " + ui);
		uis.add(ui);
	}

	public synchronized void removeMessageListener(SpringChatUI ui) {
		System.out.println("Remove listener: " + ui);
		uis.remove(ui);
	}

	public synchronized void sendMessage(String message) {
		for (SpringChatUI ui : uis.toArray(new SpringChatUI[uis.size()])) {
			ui.onMessage(message);
		}
	}

}
