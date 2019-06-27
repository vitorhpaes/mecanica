<div class="modal fade modal-services" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Selecione os serviços</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <select class="select-services form-control">
          <option selected disabled> Selecione o servico </option>
        </select>

        <table class="table table-striped services text-center">
          <thead>
            <tr>
              <th>Id</th>
              <th>Nome</th>
              <th>Horas</th>
              <th>Preco</th>
              <th>Remover</th>
            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary float-left" data-dismiss="modal">
          <i class="far fa-window-close mr-1"></i>
          Cancelar
        </button>
        <button type="button" class="btn btn-success confirm-services">
          <i class="fas fa-cart-plus mr-1"></i>
          Confirmar
        </button>
      </div>
    </div>
  </div>
</div>