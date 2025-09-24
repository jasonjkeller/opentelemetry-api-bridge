package org.example.otel.apis;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleGauge;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongUpDownCounter;

/**
 * Demonstrates how to generate OpenTelemetry dimensional metrics using the OpenTelemetry Metrics API.
 * The New Relic Java agent automatically configures the OTel SDK to export these metrics to New Relic.
 */
public class MetricsAPI {
    public MetricsAPI() {
    }

    /**
     * Generate OpenTelemetry Dimensional Metrics
     */
    public void generateOTelMetrics() {
        System.out.println("\n ===== Generating OpenTelemetry Dimensional Metrics =====\n");

        // Generate LongCounter dimensional metrics
        LongCounter longCounter = GlobalOpenTelemetry.get()
                .getMeterProvider()
                .get("opentelemetry-metrics-api-demo")
                .counterBuilder("opentelemetry-metrics-api-demo.longcounter")
                .build();
        longCounter.add(1, Attributes.of(AttributeKey.stringKey("LongCounter"), "foo"));

        System.out.println("Created LongCounter metric: " + longCounter);

        // Generate DoubleHistogram dimensional metrics
        DoubleHistogram doubleHistogram = GlobalOpenTelemetry.get()
                .getMeterProvider()
                .get("opentelemetry-metrics-api-demo")
                .histogramBuilder("opentelemetry-metrics-api-demo.histogram")
                .build();
        doubleHistogram.record(3, Attributes.of(AttributeKey.stringKey("DoubleHistogram"), "foo"));

        System.out.println("Created DoubleHistogram metric: " + doubleHistogram);

        // Generate DoubleGauge dimensional metrics
        DoubleGauge doubleGauge = GlobalOpenTelemetry.get()
                .getMeterProvider()
                .get("opentelemetry-metrics-api-demo")
                .gaugeBuilder("opentelemetry-metrics-api-demo.gauge")
                .build();
        doubleGauge.set(5, Attributes.of(AttributeKey.stringKey("DoubleGauge"), "foo"));

        System.out.println("Created DoubleGauge metric: " + doubleGauge);

        // Generate LongUpDownCounter dimensional metrics
        LongUpDownCounter longUpDownCounter = GlobalOpenTelemetry.get()
                .getMeterProvider()
                .get("opentelemetry-metrics-api-demo")
                .upDownCounterBuilder("opentelemetry-metrics-api-demo.updowncounter")
                .build();
        longUpDownCounter.add(7, Attributes.of(AttributeKey.stringKey("LongUpDownCounter"), "foo"));

        System.out.println("Created LongUpDownCounter metric: " + longUpDownCounter);
    }
}
