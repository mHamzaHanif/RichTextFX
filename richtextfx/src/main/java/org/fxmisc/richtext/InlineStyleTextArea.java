package org.fxmisc.richtext;

import java.util.function.Function;

import org.fxmisc.richtext.model.StyledTextOps;

/**
 * Text area that uses inline css derived from the style info to define
 * style of text segments.
 *
 * @param <S> type of style information.
 * @deprecated
 */
@Deprecated
public class InlineStyleTextArea<PS, SEG, S> extends GenericRichtextArea<PS, SEG, S> {

    /**
     *
     * @param initialStyle style to use for text ranges where no other
     *     style is set via {@code setStyle(...)} methods.
     * @param styleToCss function that converts an instance of {@code S}
     *     to a CSS string.
     */
    public InlineStyleTextArea(PS initialParagraphStyle, Function<PS, String> paragraphStyleToCss, S initialStyle, Function<S, String> styleToCss) {
        super(initialParagraphStyle, (paragraph, style) -> paragraph.setStyle(paragraphStyleToCss.apply(style)),
                initialStyle,
                new StyledTextOps(),
                (text, style) -> text.setStyle(styleToCss.apply(style))
        );
    }

}
