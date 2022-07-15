package at.compus02.swd.ss2022.game.repository;

import at.compus02.swd.ss2022.game.bl.interfaces.Disposable;

public interface Repository extends Disposable {
  void preload();
}
