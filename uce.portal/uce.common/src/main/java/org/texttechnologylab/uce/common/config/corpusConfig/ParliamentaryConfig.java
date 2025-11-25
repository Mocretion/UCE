package org.texttechnologylab.uce.common.config.corpusConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParliamentaryConfig {
    private boolean speaker;
    private boolean speechText;
    private boolean comment;

    /**
     * Returns true if any parliamentary annotation is enabled
     */
    public boolean isAnnotated() {
        return speaker || speechText || comment;
    }
}