package org.texttechnologylab.uce.common.models.corpus.parliamentary;

import lombok.Getter;
import lombok.Setter;
import org.texttechnologylab.uce.common.annotations.Typesystem;
import org.texttechnologylab.uce.common.models.UIMAAnnotation;
import org.texttechnologylab.uce.common.models.corpus.Document;

import javax.persistence.*;

/**
 * Represents a segment of speech text within a parliamentary protocol.
 * Each SpeechText is associated with a Speaker.
 */
@Getter
@Setter
@Entity
@Table(name = "parliamentary_speechtext")
@Typesystem(types = {org.texttechnologylab.annotation.parliamentary.SpeechText.class})
public class SpeechText extends UIMAAnnotation {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speaker_id")
    private Speaker speaker;

    public SpeechText() {
        super(-1, -1);
    }

    public SpeechText(int begin, int end) {
        super(begin, end);
    }
}