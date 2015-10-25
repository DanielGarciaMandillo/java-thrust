package org.thrust_java;

import org.utils.Json;

/**
 * Arguments TERMINADO
 *
 */
public class Arguments {

	public static Json argumentsToJson(Argument a) {
		return a.toJson();
	}

	abstract class Argument {
		public abstract Json toJson();
	}

	public RootUrl getRootUrl() {
		return new RootUrl();
	}

	public Focus getFocus() {
		return new Focus();
	}

	public Value getValue() {
		return new Value();
	}
	
	public Title getTitle() {
		return new Title();
	}

	public CookieStore getCookieStore() {
		return new CookieStore();
	}

	public Size getSize() {
		return new Size();
	}

	public Position getPosition() {
		return new Position();
	}

	public IconPath getIconPath() {
		return new IconPath();
	}

	public Url getUrl() {
		return new Url();
	}

	public Arg_CommandId getArgCommandId() {
		return new Arg_CommandId();
	}

	public Label getLabel() {
		return new Label();
	}

	public Arg_GroupId getArgGroupId() {
		return new Arg_GroupId();
	}

	public Arg_MenuId getArgMenuId() {
		return new Arg_MenuId();
	}

	public Accelerator getAccelerator() {
		return new Accelerator();
	}

	public Arg_WindowId getArgWindowId() {
		return new Arg_WindowId();
	}

	public Path getPath() {
		return new Path();
	}

	public OffTheRecord getOffTheRecord() {
		return new OffTheRecord();
	}

	class RootUrl extends Argument {

		String param;

		public RootUrl() {
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("root_url", getParam());
		}
	}

	class Focus extends Argument {

		boolean param;

		public Focus() {
		}

		public boolean getParam() {
			return param;
		}

		public void setParam(boolean param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("focus", getParam());
		}
	}

	class Title extends Argument {

		String param;

		public Title() {
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("title", getParam());
		}
	}

	class Value extends Argument {

		boolean param;

		public Value() {
		}

		public boolean getParam() {
			return param;
		}

		public void setParam(boolean param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("value", getParam());
		}
	}

	class CookieStore extends Argument {

		boolean param;

		public CookieStore() {
		}

		public boolean getParam() {
			return param;
		}

		public void setParam(boolean param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("cookie_store", getParam());
		}
	}

	class OffTheRecord extends Argument {

		boolean param;

		public OffTheRecord() {
		}

		public boolean getParam() {
			return param;
		}

		public void setParam(boolean param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("off_the_record", getParam());
		}
	}

	class Size extends Argument {

		int width, height;

		public Size() {
		}

		public int getWidth() {
			return this.width;
		}

		public int getHeight() {
			return this.height;
		}

		public void setParam(int width, int height) {
			this.width = width;
			this.height = height;
		}

		@Override
		public Json toJson() {
			return new Json("size", "width" + getWidth() + " height" + getHeight());
		}
	}

	class Position extends Argument {

		int x, y;

		public Position() {
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public void setParam(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public Json toJson() {
			return new Json("position", "width" + getX() + " height" + getY());
		}
	}

	class IconPath extends Argument {

		String param;

		public IconPath() {
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("icon_path", getParam());
		}
	}

	class Url extends Argument {

		String param;

		public Url() {
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("url", getParam());
		}
	}

	class Arg_CommandId extends Argument {

		int param;

		public Arg_CommandId() {
		}

		public int getParam() {
			return param;
		}

		public void setParam(int param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("command_id", getParam());
		}
	}

	class Label extends Argument {

		String param;

		public Label() {
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("label", getParam());
		}
	}

	class Arg_GroupId extends Argument {

		int param;

		public Arg_GroupId() {
		}

		public int getParam() {
			return param;
		}

		public void setParam(int param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("group_id", getParam());
		}
	}

	class Arg_MenuId extends Argument {

		int param;

		public Arg_MenuId() {
		}

		public int getParam() {
			return param;
		}

		public void setParam(int param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("menu_id", getParam());
		}
	}

	class Accelerator extends Argument {

		String param;

		public Accelerator() {
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("accelerator", getParam());
		}
	}

	class Arg_WindowId extends Argument {

		int param;

		public Arg_WindowId() {
		}

		public int getParam() {
			return param;
		}

		public void setParam(int param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("window_id", getParam());
		}
	}

	class Path extends Argument {

		String param;

		public Path() {
		}

		public String getParam() {
			return param;
		}

		public void setParam(String param) {
			this.param = param;
		}

		@Override
		public Json toJson() {
			return new Json("path", getParam());
		}
	}

}
