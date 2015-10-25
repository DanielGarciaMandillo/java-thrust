package org.thrust_java;

import org.utils.Json;

/**
 * Methods : TERMINADOS
 *
 */
public class Methods {

	public static Json methodsToJson(Method m) {
		return m.toJson();
	}

	abstract class Method {
		public abstract Json toJson();
	}

	public EMPTY getEmpty() {
		return new EMPTY();
	}

	class EMPTY extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "");
		}
	}

	public SHOW getShow() {
		return new SHOW();
	}

	class SHOW extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "show");
		}
	}

	public FOCUS getFocus() {
		return new FOCUS();
	}

	class FOCUS extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "focus");
		}
	}

	public MAXIMIZE getMaximize() {
		return new MAXIMIZE();
	}

	class MAXIMIZE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "maximize");
		}
	}

	public MINIMIZE getMinimize() {
		return new MINIMIZE();
	}

	class MINIMIZE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", ",minimize");
		}
	}

	public RESTORE getRestore() {
		return new RESTORE();
	}

	class RESTORE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "restore");
		}
	}

	public SET_TITLE getSetTitle() {
		return new SET_TITLE();
	}

	class SET_TITLE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_title");
		}
	}

	public SET_FULLSCREEN getSetFullscreen() {
		return new SET_FULLSCREEN();
	}

	class SET_FULLSCREEN extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_fullscreen");
		}
	}

	public SET_KIOSK getSetKiosk() {
		return new SET_KIOSK();
	}

	class SET_KIOSK extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_kiosk");
		}
	}

	public OPEN_DEV_TOOLS getOpenDevtools() {
		return new OPEN_DEV_TOOLS();
	}

	class OPEN_DEV_TOOLS extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "open_devtools");
		}
	}

	public CLOSE_DEV_TOOLS getCloseDevtools() {
		return new CLOSE_DEV_TOOLS();
	}

	class CLOSE_DEV_TOOLS extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "close_devtools");
		}
	}

	public MOVE getMove() {
		return new MOVE();
	}

	class MOVE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "move");
		}
	}

	public RESIZE getResize() {
		return new RESIZE();
	}

	class RESIZE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "resize");
		}
	}

	public IS_CLOSED getIsClosed() {
		return new IS_CLOSED();
	}

	class IS_CLOSED extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "is_closed");
		}
	}

	public SIZE getSize() {
		return new SIZE();
	}

	class SIZE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "size");
		}
	}

	public POSITION getPosition() {
		return new POSITION();
	}

	class POSITION extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "position");
		}
	}

	public IS_MAXIMIZED getIsMaximized() {
		return new IS_MAXIMIZED();
	}

	class IS_MAXIMIZED extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "is_maximized");
		}
	}

	public IS_MINIMIZED getIsMinimized() {
		return new IS_MINIMIZED();
	}

	class IS_MINIMIZED extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "is_minimized");
		}
	}

	public IS_FULLSCREEN getIsFullscree() {
		return new IS_FULLSCREEN();
	}

	class IS_FULLSCREEN extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "is_fullscreen");
		}
	}

	public IS_KIOSKED getIsKiosked() {
		return new IS_KIOSKED();
	}

	class IS_KIOSKED extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "is_kiosked");
		}
	}
	
	public IS_DEV_TOOLS_OPENED getIsDevtoolsOpened() {
		return new IS_DEV_TOOLS_OPENED();
	}

	class IS_DEV_TOOLS_OPENED extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "is_devtools_opened");
		}
	}
	
	public VISITED_LINK_ADD getVisitedLinkAdd() {
		return new VISITED_LINK_ADD();
	}

	class VISITED_LINK_ADD extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "visitedlink_add");
		}
	}
	
	public VISITED_LINK_CLEAR getVisitedLinkClear() {
		return new VISITED_LINK_CLEAR();
	}

	class VISITED_LINK_CLEAR extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "visitedlink_clear");
		}
	}
	
	
	public PROXY_SET getProxySet() {
		return new PROXY_SET();
	}

	class PROXY_SET extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "proxy_set");
		}
	}
	
	
	
	
	public PROXY_CLEAR getProxyClear() {
		return new PROXY_CLEAR();
	}

	class PROXY_CLEAR extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "proxy_clear");
		}
	}
	
	
	
	
	public IS_OFF_THE_RECORD getIsOffTheRecord() {
		return new IS_OFF_THE_RECORD();
	}

	class IS_OFF_THE_RECORD extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "is_off_the_record");
		}
	}
	
	
	public ADD_ITEM getAddItem() {
		return new ADD_ITEM();
	}

	class ADD_ITEM extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "add_item");
		}
	}
	
	
	public ADD_CHECK_ITEM getAddCheckItem() {
		return new ADD_CHECK_ITEM();
	}

	class ADD_CHECK_ITEM extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "add_check_item");
		}
	}
	
	
	public ADD_RADIO_ITEM getAddRadioItem() {
		return new ADD_RADIO_ITEM();
	}

	class ADD_RADIO_ITEM extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "add_radio_item");
		}
	}
	
	
	public ADD_SEPARATOR getAddSeparator() {
		return new ADD_SEPARATOR();
	}

	class ADD_SEPARATOR extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "add_separator");
		}
	}
	
	
	public SET_CHECKED getSetChecked() {
		return new SET_CHECKED();
	}

	class SET_CHECKED extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_checked");
		}
	}
	
	
	public SET_ENABLED getSetEnabled() {
		return new SET_ENABLED();
	}

	class SET_ENABLED extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_enabled");
		}
	}
	
	
	public SET_VISIBLE getSetVisible() {
		return new SET_VISIBLE();
	}

	class SET_VISIBLE extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_visible");
		}
	}
	
	
	public SET_ACCELERATOR getSetAccelerator() {
		return new SET_ACCELERATOR();
	}

	class SET_ACCELERATOR extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_accelerator");
		}
	}
	
	
	public ADD_SUBMENU getAddSubmenu() {
		return new ADD_SUBMENU();
	}

	class ADD_SUBMENU extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "add_submenu");
		}
	}
	
	
	public CLEAR getClear() {
		return new CLEAR();
	}

	class CLEAR extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "clear");
		}
	}
	
	
	public POPUP getPopup() {
		return new POPUP();
	}

	class POPUP extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "popup");
		}
	}
	
	
	public SET_APPLICATION_MENU getSetApplicationMenu() {
		return new SET_APPLICATION_MENU();
	}

	class SET_APPLICATION_MENU extends Method {
		@Override
		public Json toJson() {
			return new Json("_method", "set_application_menu");
		}
	}
	



}
