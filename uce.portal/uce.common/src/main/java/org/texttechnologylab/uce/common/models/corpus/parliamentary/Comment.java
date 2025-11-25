package org.texttechnologylab.uce.common.models.corpus.parliamentary;

import lombok.Getter;
import lombok.Setter;
import org.texttechnologylab.uce.common.annotations.Typesystem;
import org.texttechnologylab.uce.common.models.UIMAAnnotation;
import org.texttechnologylab.uce.common.models.corpus.Document;

import javax.persistence.*;

/**
 * Represents a parliamentary comment/interjection (applause, laughter, heckling, etc.)
 * These are inline annotations within the parliamentary protocol text.
 */
@Getter
@Setter
@Entity
@Table(name = "parliamentary_comment")
@Typesystem(types = {org.texttechnologylab.annotation.parliamentary.Comment.class})
public class Comment extends UIMAAnnotation {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    public Comment() {
        super(-1, -1);
    }

    public Comment(int begin, int end) {
        super(begin, end);
    }
}