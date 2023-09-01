<template>
    <div>
        <apexchart 
                width="800" 
                :type="type" 
                :options="options"
                :series="series"
                ref="barChart"
        ></apexchart>
    </div>
</template>

<script>
    import BaseUIComponent from './base-ui/BaseUIComponent';
    import VueApexCharts from 'vue-apexcharts';

    export default {
        mixins: [BaseUIComponent],
        name: 'PurchaseCountByPetIdChart',
        components: {
            'apexchart': VueApexCharts,
        },
        data: () => ({
            type: "bar",
            options: {
                chart: {
                    id: "purchaseCountByPetId-bar"
                },
                xaxis: {
                    categories: []
                },
            },
            series: [
                {
                    data: []
                }
            ],
            purchaseCount: [],
        }),
        async created() {
            var temp = await axios.get(axios.fixUrl('/purchaseCounts'));

            temp.data._embedded.purchaseCounts.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1]);

            this.purchaseCount = temp.data._embedded.purchaseCounts;
            const categories = [ "petId" ];
            const data = [ "count" ];

            if(this.purchaseCount && this.purchaseCount.length > 0) {
                this.purchaseCount.forEach((item) => {
                    if (item) {
                        if (categories && categories.length > 0) {
                            categories.forEach((category) => {
                                if (item[category]) {
                                    this.options.xaxis.categories.push(item[category]);
                                }
                            })
                        }
                        if (data && data.length > 0) {
                            data.forEach((val) => {
                                if (item[val]) {
                                    this.series[0].data.push(item[data]);
                                }
                            })
                        }
                    }
                });
            }

            this.$refs.barChart.refresh();
        },
        methods: {
        }
    }
</script>

