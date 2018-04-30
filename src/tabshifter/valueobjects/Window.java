package tabshifter.valueobjects;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.toHexString;

public class Window extends LayoutElement {
	public final boolean hasOneTab;
	public final boolean isCurrent;

	public Window(boolean hasOneTab, boolean isCurrent) {
		this.hasOneTab = hasOneTab;
		this.isCurrent = isCurrent;
	}

	@Override public Size size() {
		return new Size(1, 1);
	}

	@Override public String toString() {
		return "Window-" + toHexString(hashCode());
	}

	public static List<Window> allWindowsIn(LayoutElement rootElement) {
		final List<Window> result = new ArrayList<>();
		traverse(rootElement, element -> {
			if (element instanceof Window) {
				result.add((Window) element);
			}
			return true;
		});
		return result;
	}
}
