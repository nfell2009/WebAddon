package com.pikachu.webaddon.skript.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

@Name("Multiline Text")
@Description("The text from a multiline text scope")
@Examples({"text:",
		"\t<p>",
		"\thello im in a paragraph!",
		"\t</p>",
		"send back multiline text"
})
public class ExprMultilineText extends SimpleExpression<String> {

	public static String lastText;

	static {
		Skript.registerExpression(ExprMultilineText.class, String.class, ExpressionType.SIMPLE,
				"multi[( |-)]line (string|text)");
	}

	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
		return true;
	}

	@Override
	protected String[] get(Event e) {
		return new String[]{lastText};
	}

	@Override
	public boolean isSingle() {
		return true;
	}

	@Override
	public Class<? extends String> getReturnType() {
		return String.class;
	}

	@Override
	public String toString(Event e, boolean debug) {
		return "multiline string";
	}

}
