import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

class GraphicsCardCard extends PolymerElement {
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
                
                .connections {
                    grid-column: span 2;
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
                <div class="card-model">[[partCard.cardModel]]</div>
                <div class="connections">[[partCard.connections]]</div>
                <div class="pci-express-version">[[partCard.pciExpressVersion]]</div>
                <div class="cooling-system">[[partCard.coolingSystem]]</div>
            </div>
        `;
    }

    static get is() {
        return 'graphics-card-card';
    }
}

window.customElements.define(GraphicsCardCard.is, GraphicsCardCard);
