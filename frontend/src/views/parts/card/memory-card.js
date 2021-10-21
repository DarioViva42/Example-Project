import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class MemoryCard extends PolymerElement {
    static get template() {
        return html`
            <style>
                :host {
                    display: block;
                }
                
                .content {
                    display: grid;
                    grid-template-columns: repeat(3, 1fr);
                }

                @media (min-width: 1300px) {
                    .content {
                        grid-template-columns: repeat(6, 1fr);
                    }
                }
            </style>
            <div class="content">
                <div class="name">[[partCard.name]]</div>
                <div class="price">[[partCard.price]]</div>
                <div class="stock">[[partCard.stock]]</div>
                <div class="configuration">[[partCard.configuration]]</div>
                <div class="form-factor">[[partCard.formFactor]]</div>
                <div class="frequency">[[partCard.frequency]] Mhz</div>
            </div>
        `;
    }

    static get is() {
        return 'memory-card';
    }
}

window.customElements.define(MemoryCard.is, MemoryCard);
