package model.mediator.propertyChange;

import java.beans.PropertyChangeListener;

public interface NamedPropertyChangeSubject
{
  void addListener(String propertyName, PropertyChangeListener listener)
      throws Exception;
  void removeListener(String propertyName, PropertyChangeListener listener);
}
